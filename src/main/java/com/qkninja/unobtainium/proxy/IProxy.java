package com.qkninja.unobtainium.proxy;

/**
 * Interface for roxy classes.
 */
public interface IProxy
{
    /**
     * Runs on initialization (client), registers keys, assigns defaults if unassigned.
     */
    public abstract void registerKeyBindings();
}
