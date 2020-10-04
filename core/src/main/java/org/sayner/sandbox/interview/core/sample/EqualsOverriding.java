package org.sayner.sandbox.interview.core.sample;

import org.sayner.sandbox.interview.library.SampleI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EqualsOverriding implements SampleI {
    private final Logger LOGGER = LoggerFactory.getLogger(EqualsOverriding.class);
    private final String one;
    private final String two;
    private final String three;

    public EqualsOverriding() {
        this("one", "two", "three");
    }

    public EqualsOverriding(String one, String two, String three) {
        this.one = one;
        this.two = two;
        this.three = three;
    }

    @Override
    public void runExample() {
        final EqualsOverriding x = new EqualsOverriding();
        final EqualsOverriding y = new EqualsOverriding();
        final EqualsOverriding z = new EqualsOverriding();
        LOGGER.info("How to override equals:\n" +
                        "Reflexive - an object must equal to itself\n" +
                        "Symmetry\n" +
                        "Transitive\n" +
                        "Consistent - no value is modified, then it's always true for every call\n" +
                        "For any non-null object x x.equals(null) == false\n" +
                        "Reflexive: x.equals(x)=={}\n" +
                        "Symmetry: if x.equals(y)=={} then y.equals(x)=={}\n" +
                        "Transitive: if x.equals(y) and y.equals(z); then x.equals(z) is {}\n" +
                        "Consistent: if x.equals(y)==true, it is always true\n" +
                        "x.equals(null)=={}",
                x.equals(x),
                x.equals(y),
                y.equals(x),
                x.equals(z),
                x.equals(null)
        );
        // Reflexive
        assert x.equals(x);
        // Symmetry
        if (x.equals(y))
            assert y.equals(x);
        else
            assert !y.equals(x);
        // Transitive
        assert !(x.equals(y) & y.equals(z)) || x.equals(z);
        // Consistent
        for (int i = 0; i < 3; i++) {
            assert x.equals(y);
            assert x.equals(z);
            assert y.equals(z);
        }
        assert !x.equals(null);

    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof EqualsOverriding)) {
            return false;
        }

        return this.one.equals(((EqualsOverriding) obj).one)
                && this.two.equals(((EqualsOverriding) obj).two)
                && this.three.equals(((EqualsOverriding) obj).three);
    }
}
