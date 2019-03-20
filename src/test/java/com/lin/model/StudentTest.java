package com.lin.model;


public class StudentTest {
    @Test
    public void TeseInsert() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Student.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

}
