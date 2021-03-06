package com.nhl.link.rest;

import org.apache.cayenne.di.Injector;

import javax.ws.rs.core.Feature;

/**
 * A provider of a custom JAX-RS Feature that will be loaded in the JAX-RS runtime as a part of LinkRest startup.
 * This object is either directly with {@link com.nhl.link.rest.runtime.LinkRestBuilder} or is auto-loaded via
 * {@link java.util.ServiceLoader} mechanism.
 */
public interface LrFeatureProvider {

    Feature feature(Injector injector);
}
