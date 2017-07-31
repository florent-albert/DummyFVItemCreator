package com.ptc.ssp.fv.dummy;

public class StoredFVItem
{
	String fileName;
    int fileSize;
    String filePath;
    String fvItemName;
    
	public StoredFVItem(String fileName, int fileSize, String filePath, String fvItemName)
	{
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.filePath = filePath;
		this.fvItemName = fvItemName;
	}
	
	public String getFileName()
	{
		return fileName;
	}
	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}
	public int getFileSize()
	{
		return fileSize;
	}
	public void setFileSize(int fileSize)
	{
		this.fileSize = fileSize;
	}
	public String getFilePath()
	{
		return filePath;
	}
	public void setFilePath(String filePath)
	{
		this.filePath = filePath;
	}
	public String getFvItemName()
	{
		return fvItemName;
	}
	public void setFvItemName(String fvItemName)
	{
		this.fvItemName = fvItemName;
	}
    
}
