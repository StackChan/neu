package com.neu.tools;

import java.util.List;

//一个具有增删改查功能的接口
public interface Functional<E> {
    public void add(List<E> list,String id);
    public void delete(List<E> list,String id);
    public void fix(List<E> list,String id);
    public E search(List<E> list,String id);

}
