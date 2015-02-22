package webapp.bean;

import webapp.core.BeanAbstract;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maxime on 2/22/2015.
 */
public class BeanFactory {
    
    public static <H extends BeanAbstract> List<H> convert(final Class<H> beanClass, List models) throws Exception {
        ArrayList<H> beans = new ArrayList<H>();
        for(Object model : models){
            beans.add( BeanFactory.convert(beanClass, model) );
        }
        return beans;
    }

    public static <H extends BeanAbstract> H convert(final Class<H> beanClass, Object model) throws Exception{
        H bean = beanClass.newInstance();
        bean.loadFromModel(model);
        return bean;
    }
}
