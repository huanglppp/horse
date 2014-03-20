package com.horse.common.util;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import com.horse.BaseTest;
import com.horse.common.exception.BaseException;

public class FileUtilTest extends BaseTest {

	@Test
	public void testGetClassPathFile(){
		try {
			File file = FileUtil.getClassPathFile("jackson/user.json");
			equalTo("存在", file.exists(), true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetClassPathFile_isBank(){
		try {
			File file = FileUtil.getClassPathFile("");
			nullValue("为null", file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test(expected=FileNotFoundException.class)
	public void testGetClassPathFile_NoExists() throws IOException{
		FileUtil.getClassPathFile("jackson/user1.json");
	}
	
	@Test
	public void testCreateClassPathFile() throws IOException, BaseException{
		File file = FileUtil.createClassPathFile("aa/bbb/bb.txt");
		equalTo("存在", file.exists(), true);
	}
}
