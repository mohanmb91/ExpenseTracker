package helper;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

import gigster.model.Expense;
import gigster.model.User;



public class GeneratePdfInRange extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> models, Document document, PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			response.setHeader("content-disposition", "inline; filename=myFile.pdf");
			response.setHeader("Content-Type","application/pdf");
			List<Expense> expenses= (List<Expense>) models.get("reportsInRange");
			
			
			
			Table table = new Table(3);
			table.addCell("Expense Descripton");
			table.addCell("Expense Date");
			table.addCell("Expense Amount");
			
			for(Expense eachExpense:expenses){
				table.addCell(eachExpense.getDescription());
				table.addCell(convertDateToString(eachExpense.getTransactionTime()));
				table.addCell(eachExpense.getAmount().toString());
			}
			
			
			document.add(table);
			document.close();
	}
	
	public static String convertDateToString(Date date){
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date today = date;        
		String reportDate = df.format(today);
		return reportDate;
		
	}
	
}
