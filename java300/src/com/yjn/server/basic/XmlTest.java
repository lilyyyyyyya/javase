package com.yjn.server.basic;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * 熟悉SAX解析流程
 * @author 82305
 *
 */
public class XmlTest {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		//获取解析工厂
		SAXParserFactory factory=SAXParserFactory.newInstance();
		//获得解析器
		SAXParser parser=factory.newSAXParser();
		//编写处理器
		//加载文档处理器
		PersonHandler handler=new PersonHandler();
		//解析
		parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("com/yjn/server/basic/xmltest.xml"),handler);
		List<Person> list=handler.getList();
		for(Person p:list) {
			System.out.println(p.getName()+"--"+p.getAge());
		}
	}
}
class PersonHandler extends DefaultHandler{
	private List<Person> list;
	private Person person;
	private String tag;
	
	
	public List<Person> getList() {
		return list;
	}
	public void setList(List<Person> list) {
		this.list = list;
	}
	@Override
	public void startDocument() throws SAXException {
		System.out.println("---------解析文档开始---------");
		list=new ArrayList<>();
	}
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println(qName+"---解析开始");
		if(qName!=null) {
			tag=qName;
			if(tag.equals("person")) {
				person=new Person();
			}
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String content=new String(ch,start,length).trim();
		if(tag!=null) {
			if(tag.equals("name")) {
				person.setName(content);
			}else if(tag.equals("age")) {
				person.setAge(Integer.valueOf(content));
			}
		}
	}
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println(qName+"---解析结束");
		if(qName!=null) {
			if(qName.equals("person")) {
				list.add(person);
			}
		}
		tag=null;
	}
	@Override
	public void endDocument() throws SAXException {
		System.out.println("---------解析文档结束------------");
	}
}
