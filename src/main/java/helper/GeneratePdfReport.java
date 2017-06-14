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



public class GeneratePdfReport extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> models, Document document, PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			response.setHeader("Content-Disposition", "attachment: filename=\"weeklyreports.pdf\"");
			response.setHeader("Content-Type","application/pdf");
			List<WeekReport> weeklyReports= (List<WeekReport>) models.get("weeklyReports");
			
			
			
			Table table = new Table(3);
			table.addCell("Start Date");
			table.addCell("End Date");
			table.addCell("Total Expense occured within the duration");
			
			for(WeekReport eachWeekReport:weeklyReports){
				table.addCell(convertDateToString(eachWeekReport.startDate));
				table.addCell(convertDateToString(eachWeekReport.endDate));
				table.addCell(eachWeekReport.totalWeekExpense.toString());
			}
			
			
			document.add(table);
			document.close();
	}
	
	public static String convertDateToString(Date date){
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

		// Get the date today using Calendar object.
		Date today = date;
		
		// Using DateFormat format method we can create a string 
		// representation of a date with the defined format.
		String reportDate = df.format(today);
		return reportDate;
		
	}
	
}
