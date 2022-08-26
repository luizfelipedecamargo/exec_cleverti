package com.cleverti.feefo.test.java;

import com.cleverti.feefo.main.java.NormalizeJobTitles;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NormalizeJobTitlesTest {

    static final NormalizeJobTitles normalizeJobTitles = new NormalizeJobTitles();

    @Test
    public void testNormalise(){
        assertEquals("Software engineer",normalizeJobTitles.normalise("Java engineer"));
        assertEquals("Software engineer",normalizeJobTitles.normalise("C# engineer"));
        assertEquals("Accountant",normalizeJobTitles.normalise("Accountant"));
        assertEquals("Accountant",normalizeJobTitles.normalise("Chief Accountant"));
    }
}
