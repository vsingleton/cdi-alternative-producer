package info.alternative;

import static javax.interceptor.Interceptor.Priority.APPLICATION;

import info.cdi.Shift;
import info.alternative.AltShiftImpl;

import javax.annotation.Priority;
import javax.enterprise.inject.Alternative;

import static java.util.Arrays.asList;
import static java.util.Collections.emptySet;
import static java.util.Collections.singleton;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;

import javax.enterprise.inject.Default;
import javax.enterprise.util.AnnotationLiteral;

import javax.enterprise.context.Dependent;
import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Qualifier;
import javax.interceptor.Interceptor;

@Dependent
@Alternative
@Priority(APPLICATION+10)
public class AltDynamicShiftProducer implements Bean<Shift> {

    public AltDynamicShiftProducer() {
        System.err.println("AltDynamicShiftProducer: ...");
    }

    @SuppressWarnings("all")
    public static class DefaultAnnotationLiteral extends AnnotationLiteral<Default> implements Default {
        private static final long serialVersionUID = 1L;
    }

    public static class PriorityLiteral extends AnnotationLiteral<Priority> implements Priority {

        public int value() {
            return Interceptor.Priority.APPLICATION+10;
        }

    }
 
    @Override
    public Class<?> getBeanClass() {
        return Shift.class;
    }
 
    @Override
    public Set<Type> getTypes() {
        return new HashSet<Type>(asList(Shift.class, Object.class));
    }
 
    @Override
    public Shift create(CreationalContext<Shift> creationalContext) {
        return new AltShiftImpl("Hello, AltShift.");
    }
 
    @Override
    public Set<Annotation> getQualifiers() {
        Set<Annotation> qualifiers = new HashSet<Annotation>();
        qualifiers.add( new DefaultAnnotationLiteral());
        // qualifiers.add( new PriorityLiteral());
        // qualifiers.add( new UseTheMagicAnnotationLiteral());
        // qualifiers.add( new AnyAnnotationLiteral());
        return qualifiers;

        // return singleton((Annotation) new DefaultAnnotationLiteral());
    }
 
    @Override
    public Class<? extends Annotation> getScope() {
        return Dependent.class;
    }
 
    @Override
    public Set<Class<? extends Annotation>> getStereotypes() {
        return emptySet();
    }
 
    @Override
    public Set<InjectionPoint> getInjectionPoints() {
        return emptySet();
    }
 
    @Override
    public boolean isAlternative() {
        return true;
    }
 
    @Override
    public boolean isNullable() {
        return false;
    }
 
    @Override
    public String getName() {
        return null;
    }
 
    @Override
    public void destroy(Shift instance, CreationalContext<Shift> creationalContext) {
 
    }

}

