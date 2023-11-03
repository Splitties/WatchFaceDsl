package louis2.wear.wff.attr

import louis2.wear.wff.common.attributes.ArithmeticExpression
import kotlin.properties.ReadOnlyProperty

abstract class AttrsHost {
    protected fun string(): ReadOnlyProperty<AttrsHost, AttrRef<ArithmeticExpression.String>> = p()
    protected fun int(): ReadOnlyProperty<AttrsHost, AttrRef<ArithmeticExpression.Int>> = p()
    protected fun float(): ReadOnlyProperty<AttrsHost, AttrRef<ArithmeticExpression.Float>> = p()
    protected fun boolean(): ReadOnlyProperty<AttrsHost, AttrRef<ArithmeticExpression.Boolean>> = p()

    private fun <T : ArithmeticExpression> p(): ReadOnlyProperty<AttrsHost, AttrRef<T>> =
        ReadOnlyProperty { _, property -> AttrRef(property.name) }
}
