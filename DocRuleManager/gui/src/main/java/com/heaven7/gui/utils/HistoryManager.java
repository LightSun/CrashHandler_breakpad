package com.heaven7.gui.utils;

import java.util.ArrayList;
import java.util.List;

public class HistoryManager<T> {

    private final List<T> m_list = new ArrayList<>();
    private int m_curIdx = 0;

    public T current(){
        if(m_curIdx < 0 || m_curIdx >= m_list.size()){
            return null;
        }
        return m_list.get(m_curIdx);
    }
    public T next(){
        if(m_curIdx + 1 < m_list.size()){
            m_curIdx ++;
        }else{
            m_curIdx = 0;
        }
        return current();
    }

    public T previous(){
        if(m_curIdx > 0){
            m_curIdx --;
        }else{
            m_curIdx = m_list.size() - 1;
        }
        return current();
    }
    public void add(T t){
        m_list.add(t);
        m_curIdx = m_list.size() - 1;
    }
    public void clear(){
        m_list.clear();
        m_curIdx = -1;
    }
}
