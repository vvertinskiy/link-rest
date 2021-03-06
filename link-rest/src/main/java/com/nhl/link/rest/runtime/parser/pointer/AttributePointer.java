package com.nhl.link.rest.runtime.parser.pointer;

import com.nhl.link.rest.meta.LrAttribute;
import com.nhl.link.rest.meta.LrEntity;

class AttributePointer extends SimplePointer {

    private LrAttribute attribute;

    AttributePointer(SimplePointer predecessor, LrEntity<?> entity, LrAttribute attribute) {
        super(predecessor, entity);
        this.attribute = attribute;
    }

    @Override
    protected Object doResolve(PointerContext context, Object baseObject) {

        if (baseObject == null) {
            throw new IllegalArgumentException("Null base object passed to pointer: " + toString());
        }

        return context.resolveProperty(baseObject, attribute.getName());
    }

    @Override
    protected String encodeToString() {
        return attribute.getName();
    }

    @Override
    public PointerType getType() {
        return PointerType.ATTRIBUTE;
    }

    @Override
    public Class<?> getTargetType() {
        return attribute.getType();
    }

    LrAttribute getAttribute() {
        return attribute;
    }
}
