package wci.backend;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JSOUP 
{
	public static void main(String []args) throws IOException
	{
		//String html = "http://online.sjsu.edu/docs/cies/2161_WINTER_IES.htm";
		
		//printFullTable(html, 2);
		
		//printData(html, 2, 2, 1);
	}
	
	public static String errorMessage = "";
	
	public static void printFullTable(String filename,int tableNum) throws IOException
	{
		
		int t = 1;
		try
		{
			Document html = Jsoup.connect(filename).get();
			Elements tables = html.select("table");
			for(Element table : tables)
			{
				if(t == tableNum)
				{
					Elements rows = table.select("tr");
					for(Element row : rows)
					{
						Elements columns = row.select("td");
						for(Element column : columns)
							System.out.print(" | " + column.text());
						System.out.println("");
					}
				}
				t++;
			}
		}
		catch(IOException e)
		{
			errorMessage = e.toString();
		}
	}
	
	public static void printData(String filename, int tableNum, int x, int y)
	{
		int t = 1;
		try
		{
			Document html = Jsoup.connect(filename).get();
			Elements tables = html.select("table");
			for(Element table : tables)
			{
				if(t == tableNum)
				{
					int i = 1;
					int j = 1;
					Elements rows = table.select("tr");
					for(Element row : rows)
					{
						if(i == x)
						{
							Elements columns = row.select("td");
							for(Element column : columns)
							{
								if(j == y)
									System.out.print(" | " + column.text());
								j++;
							}
							System.out.println("");
						}
						i++;
					}
				}
				t++;
			}
		}
		catch(IOException e)
		{
			e.toString();
		}
	}
	
	public static String getData(String filename, int tableNum, int x, int y)
	{
		int t = 1;
		String result = "";
		try
		{
			Document html = Jsoup.connect(filename).get();
			Elements tables = html.select("table");
			for(Element table : tables)
			{
				if(t == tableNum)
				{
					int i = 1;
					int j = 1;
					Elements rows = table.select("tr");
					for(Element row : rows)
					{
						if(i == x)
						{
							Elements columns = row.select("td");
							for(Element column : columns)
							{
								if(j == y)
									result += (column.text());
								j++;
							}
							result +="";
						}
						i++;
					}
				}
				t++;
			}
			
		}
		catch(IOException e)
		{
			e.toString();
		}
		return result;
	}
}
