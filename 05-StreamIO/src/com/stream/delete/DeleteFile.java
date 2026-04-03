package com.stream.delete;

import java.io.File;

public class DeleteFile {

	public static void main(String[] args) {

		File obj = new File("myFile.txt");

		if (obj.delete()) {

			System.out.println("File deleted sucessfully");
		} else {
			System.out.println("Fail File delete file");
		}
	}

}
