package com.max.mock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class MockTest {

    @Test
    public void testMockInterface() {
        List mockList = mock(List.class);

        mockList.add("one");
        mockList.clear();

        verify(mockList).add("one");
        verify(mockList).clear();
    }

    @Test
    public void testMockArrayList() {
        final ArrayList<String> mockArrayList = mock(ArrayList.class);

        when(mockArrayList.get(0)).thenReturn("first");
        when(mockArrayList.get(1)).thenThrow(new RuntimeException("out"));


        System.out.println(mockArrayList.get(0));
        Assertions.assertEquals("first", mockArrayList.get(0));

        Assertions.assertThrows(RuntimeException.class, new Executable() {
            public void execute() throws Throwable {
                mockArrayList.get(1);
            }
        });

        Assertions.assertNull(mockArrayList.get(999));

    }
}
