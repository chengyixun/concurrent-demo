package com.example.concurrentlearn.msb;

import com.google.common.collect.Lists;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;

/**
 * @ClassName: HashMapTest
 * @Author: amy
 * @Description: HashMapTest
 * @Date: 2021/11/10
 * @Version: 1.0
 */
public class HashMapTest {
  public static void main(String[] args) {
    //

      HashMap<String, List<String >> map = new HashMap<>();
      map.put("key1", Lists.newArrayList("a","b","d","e","f","g","h","i","2"));
      List<String> value = map.get("key1");
      if(!CollectionUtils.isEmpty(value)){
          value.addAll(Lists.newArrayList("y","p"));
          map.put("key1",value);
      }


  }
}
