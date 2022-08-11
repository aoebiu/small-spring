package xyz.mengnan.smallspring.beans.factory.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import xyz.mengnan.smallspring.beans.BeansException;
import xyz.mengnan.smallspring.beans.PropertyValue;
import xyz.mengnan.smallspring.beans.PropertyValues;
import xyz.mengnan.smallspring.beans.factory.config.BeanDefinition;
import xyz.mengnan.smallspring.beans.factory.config.BeanReference;
import xyz.mengnan.smallspring.beans.factory.support.AbstractBeanDefinitionReader;
import xyz.mengnan.smallspring.beans.factory.support.BeanDefinitionRegistry;
import xyz.mengnan.smallspring.core.io.Resource;
import xyz.mengnan.smallspring.core.io.ResourceLoader;
import xyz.mengnan.smallspring.util.Assert;
import xyz.mengnan.smallspring.util.StringUtils;

import java.io.InputStream;

public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    private DocumentLoader documentLoader = new DefaultDocumentLoader();

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        super(registry, resourceLoader);
    }

    public void setDocumentLoader(DocumentLoader documentLoader) {
        this.documentLoader = documentLoader == null ? new DefaultDocumentLoader() : documentLoader;
    }

    @Override
    public void loadBeanDefinitions(Resource resource) throws BeansException {
        try (InputStream inputStream = resource.getInputStream()) {
            doLoadBeanDefinitions(inputStream);
        } catch (Exception e) {
            throw new BeansException("IOException parsing XML document from " + resource, e);
        }
    }

    @Override
    public void loadBeanDefinitions(Resource... resources) throws BeansException {
        for (Resource resource : resources) {
            loadBeanDefinitions(resource);
        }
    }

    @Override
    public void loadBeanDefinitions(String location) throws BeansException {
        ResourceLoader resourceLoader = getResourceLoader();
        Resource resource = resourceLoader.getResource(location);
        loadBeanDefinitions(resource);
    }

    protected void doLoadBeanDefinitions(InputStream inputStream) throws Exception {
        Document doc = documentLoader.loadDocument(inputStream);
        Element root = doc.getDocumentElement();
        NodeList nl = root.getChildNodes();

        for (int i = 0; i < nl.getLength(); i++) {
            Node node = nl.item(i);
            if (!(node instanceof Element)) {
                continue;
            }

            Element ele = (Element) node;
            String id = ele.getAttribute("id");
            String className = ele.getAttribute("class");
            Class<?> clazz = Class.forName(className);

            String beanName;
            if (id != null) {
                beanName = id;
            } else {
                beanName = StringUtils.lowerFirst(clazz.getSimpleName());
            }

            BeanDefinition beanDefinition = new BeanDefinition(clazz);
            NodeList childNodes = ele.getChildNodes();

            for (int j = 0; j < childNodes.getLength(); j++) {
                Node childNode = childNodes.item(j);
                if (!"property".equals(childNode.getNodeName())) {
                    continue;
                }
                Element property = (Element) childNode;
                String name = property.getAttribute("name");
                String value = property.getAttribute("value");
                String ref = property.getAttribute("ref");

                Object v = StringUtils.isEmpty(ref) ? value : new BeanReference(ref);
                PropertyValue propertyValue = new PropertyValue(name, v);
                beanDefinition.getPropertyValues().addPropertyValue(propertyValue);

                if (getRegistry().containsBeanDefinition(beanName)) {
                    throw new BeansException("Duplicate beanName' " + beanName + " ' is not allowed");
                }
            }
            getRegistry().registerBeanDefinition(beanName, beanDefinition);
        }
    }
}
