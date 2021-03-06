package com.nhl.link.rest.runtime.processor.update;

import com.nhl.link.rest.UpdateStage;
import com.nhl.link.rest.processor.Processor;
import com.nhl.link.rest.processor.ProcessorFactory;

import java.util.EnumMap;

/**
 * @since 2.7
 */
public class UpdateProcessorFactory extends ProcessorFactory<UpdateStage, UpdateContext<?>> {

    public UpdateProcessorFactory(EnumMap<UpdateStage, Processor<UpdateContext<?>>> defaultStages) {
        super(defaultStages);
    }
}
