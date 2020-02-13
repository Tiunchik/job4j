/**
 * Пакет ru.job4j.magnit для решения тестового здания магазина Магнит с использованем SQLlite
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.magnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

/**
 * Класс Parser - клас для подсчёта значний в xml файле, преобразованном через Convert
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 07.02.2020
 */
public class Parser {
    private static final Logger LOG = LogManager.getLogger(Parser.class.getName());

    private static int answer = 0;

    public static int parserSAX(File input) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            XMLHandler handler = new XMLHandler();
            try {
                parser.parse(input, handler);
                System.out.println(answer);
                return answer;
            } catch (IOException r) {
                LOG.error("Download xml error", r);
            }
        } catch (SAXException | ParserConfigurationException e) {
            LOG.error("SAX/Parser error", e);
        }
        return 0;
    }

    public static class XMLHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("entry")) {
                int getScore = Integer.parseInt(attributes.getValue("href"));
                answer += getScore;
            }
        }
    }

    public static int getAnswer() {
        return answer;
    }
}