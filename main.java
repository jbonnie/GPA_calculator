import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[] grades_all = new int[13];		// save the number of each grades (A+ ~ F, about every class)
	public static int[] grades_major = new int[13];		// save the number of each grades (A+ ~ F, about major class)
	public static int number_all = 0;
	public static int number_major = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		System.out.println("1. Please enter a perfect score (4.3 or 4.5)");
		double perfect_score = Double.parseDouble(bf.readLine());		// 4.3 or 4.5
		System.out.println("2. Please enter your whole grades line by line");
		System.out.println("- For a major class, please enter 1. Otherwise enter 0");
		System.out.println("- Ex) A+ 0, A0 1...");
		System.out.println("- You have to separate two things by space");
		System.out.println("- If you're done, please enter \"end\"");
		
		// Start to get an input 
		while(true) {
			String input = bf.readLine();
			if(input.equals("end"))
				break;		// finish getting an input
			StringTokenizer stk = new StringTokenizer(input);
			String grade = stk.nextToken();
			int major_check = Integer.parseInt(stk.nextToken());
			getting_input(grade, major_check);
		}
		
		// result: always rounded to the second digit after the decimal point
		double average_all = 0;
		double average_major = 0;
		double score[] = new double[13];
		if(perfect_score == 4.3)
			score = new double[]{4.3, 4.0, 3.7, 3.3, 3.0, 2.7, 2.3, 2.0, 1.7, 1.3, 1.0, 0.7, 0.0};
		else 
			score = new double[]{4.5, 4.0, 0.0, 3.5, 3.0, 0.0, 2.5, 2.0, 0.0, 1.5, 1.0, 0.0, 0.0}; 
		for(int i = 0; i < 13; i++)
		{
			average_all += grades_all[i] * score[i];
			average_major += grades_major[i] * score[i];
		}
		average_all /= number_all;
		average_major /= number_major;
		
		if(perfect_score == 4.3) {	// 1) grades out of 4.3
			double all_45 = Math.round(average_all/4.3*4.5*100)/100.0;
			double major_45 = Math.round(average_major/4.3*4.5*100)/100.0;
			sb.append("* GPA (/4.3): ");
			sb.append(Math.round(average_all*100)/100.0).append("\n");
			sb.append("* GPA (/4.5): " + all_45 + "\n");
			sb.append("* Major GPA (/4.3): ");
			sb.append(Math.round(average_major*100)/100.0).append("\n");
			sb.append("* Major GPA (/4.5): " + major_45);
		} 
		else {		// 2) grades out of 4.5
			double all_43 = Math.round(average_all/4.5*4.3*100)/100.0;
			double major_43 = Math.round(average_major/4.5*4.3*100)/100.0;
			sb.append("* GPA (/4.3): " + all_43 + "\n");
			sb.append("* GPA (/4.5): ");
			sb.append(Math.round(average_all*100)/100.0).append("\n");
			sb.append("* Major GPA (/4.3): " + major_43);
			sb.append("* Major GPA (/4.5): ");
			sb.append(Math.round(average_major*100)/100.0).append("\n");
		}
		System.out.println(sb);
	}
	// update 'grades_all' and 'grades_major' arrays
	public static void getting_input(String grade, int major_check) {
		number_all++;
		if(major_check == 1)
			number_major++;
		switch(grade) {
		case "A+": 
			grades_all[0]++;
			if(major_check == 1) 
				grades_major[0]++;
			break;
		case "A0": 
			grades_all[1]++;
			if(major_check == 1) 
				grades_major[1]++;
			break;
		case "A-": 
			grades_all[2]++;
			if(major_check == 1) 
				grades_major[2]++;
			break;
		case "B+": 
			grades_all[3]++;
			if(major_check == 1) 
				grades_major[3]++;
			break;
		case "B0": 
			grades_all[4]++;
			if(major_check == 1) 
				grades_major[4]++;
			break;
		case "B-": 
			grades_all[5]++;
			if(major_check == 1) 
				grades_major[5]++;
			break;
		case "C+": 
			grades_all[6]++;
			if(major_check == 1) 
				grades_major[6]++;
			break;
		case "C0": 
			grades_all[7]++;
			if(major_check == 1) 
				grades_major[7]++;
			break;
		case "C-": 
			grades_all[8]++;
			if(major_check == 1) 
				grades_major[8]++;
			break;
		case "D+": 
			grades_all[9]++;
			if(major_check == 1) 
				grades_major[9]++;
			break;
		case "D0": 
			grades_all[10]++;
			if(major_check == 1) 
				grades_major[10]++;
			break;
		case "D-": 
			grades_all[11]++;
			if(major_check == 1) 
				grades_major[11]++;
			break;
		case "F": 
			grades_all[12]++;
			if(major_check == 1) 
				grades_major[12]++;
			break;
		}
	}
}