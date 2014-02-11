package com.horse.common.util;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Ignore;
import org.junit.Test;

import com.horse.common.exception.BaseException;

public class FileUtilTest {

	@Test
	@Ignore
	public void testGetClassPathFile(){
		try {
			File file = FileUtil.getClassPathFile("jackson/user.json");
			assertThat("存在", file.exists(), equalTo(true));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Ignore
	public void testGetClassPathFile_isBank(){
		try {
			File file = FileUtil.getClassPathFile("");
			assertThat("为null", file, nullValue());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test(expected=FileNotFoundException.class)
	@Ignore
	public void testGetClassPathFile_NoExists() throws IOException{
		FileUtil.getClassPathFile("jackson/user1.json");
	}
	
	@Test
	public void testCreateClassPathFile() throws IOException, BaseException{
		File file = FileUtil.createClassPathFile("aa/bbb/bb.txt");
		assertThat("存在", file.exists(), equalTo(true));
	}
}
