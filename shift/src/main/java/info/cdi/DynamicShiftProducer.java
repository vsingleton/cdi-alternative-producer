package info.cdi;

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

public class DynamicShiftProducer implements Bean<Shift> {

    public DynamicShiftProducer() {
        System.err.println("DynamicShiftProducer: ...");
    }

    @SuppressWarnings("all")
    public static class DefaultAnnotationLiteral extends AnnotationLiteral<Default> implements Default {
        private static final long serialVersionUID = 1L;
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
        return new ShiftImpl("Hello, Shift.");
    }

    @Override
    public Set<Annotation> getQualifiers() {
        Set<Annotation> qualifiers = new HashSet<Annotation>();
        qualifiers.add( new DefaultAnnotationLiteral());
        return qualifiers;
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
        return false;
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

