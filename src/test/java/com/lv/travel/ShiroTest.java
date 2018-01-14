package com.lv.travel;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.junit.Test;

public class ShiroTest extends BaseJunitTest{
	@Test
	public void test0(){  
   
        ByteSource salt=ByteSource.Util.bytes("xbl");
        SimpleHash sh=new SimpleHash("MD5", "123456", salt,16);
        System.out.println(sh.toString());
        
    }   
	
	
	@Test
	public void test2(){  
        SimpleHash sh=new SimpleHash("MD5", "860916037906894", null,1);
        System.out.println(sh.toString());
        
    }   
}
