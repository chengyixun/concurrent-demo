package com.example.concurrentlearn.msb;

import org.openjdk.jol.info.ClassLayout;

/**
 * @ClassName: Test1
 * @Author: amy
 * @Description: Test1
 * @Date: 2021/11/7
 * @Version: 1.0
 */
public class Test1 {
	public static void main(String[] args) {
		//
		Object o = new Object();
		System.out.println(ClassLayout.parseInstance(o).toPrintable());
	}
}
