package com.example.completecalc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    boolean usePoint = false;
    boolean isMainOperation = false;
    String expression = "";
    char operationFromExpression;
    List<Character> restriction = new ArrayList<Character>();
    List<Character> operations = new ArrayList<Character>();
    List<Character> lastChar = new ArrayList<Character>();
    List<Character> mainOperations = new ArrayList<Character>();
    List<Character> secondOperations = new ArrayList<Character>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        restriction.add('/');restriction.add('+');restriction.add('-');restriction.add('x');restriction.add('.');
        operations.add('/');operations.add('+');operations.add('-');operations.add('x');
        mainOperations.add('x');mainOperations.add('/');
        secondOperations.add('+');secondOperations.add('-');
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        final TextView lastChar = (TextView) findViewById(R.id.lastChar);

        //Operations
        Button buttonPlus = (Button) findViewById(R.id.buttonPlus);
        Button buttonLess = (Button) findViewById(R.id.buttonLess);
        Button buttonDivided = (Button) findViewById(R.id.buttonDivided);
        Button buttonC = (Button) findViewById(R.id.buttonC);
        Button buttonBackSpace = (Button) findViewById(R.id.buttonBackSpace);
        Button buttonTimes = (Button) findViewById(R.id.buttonTimes);
        Button buttonEqual = (Button) findViewById(R.id.buttonEqual);

        //Numbers
        Button buttonOne = (Button) findViewById(R.id.buttonOne);
        Button buttonTwo = (Button) findViewById(R.id.buttonTwo);
        Button buttonThree = (Button) findViewById(R.id.buttonThree);
        Button buttonFour = (Button) findViewById(R.id.buttonFour);
        Button buttonFive = (Button) findViewById(R.id.buttonFive);
        Button buttonSix = (Button) findViewById(R.id.buttonSix);
        Button buttonSeven = (Button) findViewById(R.id.buttonSeven);
        Button buttonEight = (Button) findViewById(R.id.buttonEight);
        Button buttonNine = (Button) findViewById(R.id.buttonNine);
        Button buttonZero = (Button) findViewById(R.id.buttonZero);

        Button buttonPoint = (Button) findViewById(R.id.buttonPoint);

        //View
        final TextView mathExpression = (TextView) findViewById(R.id.mathExpression);
        buttonOne.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                if(expression == "ERRO!!"){
                    lastChar.clear();
                    expression = "";
                }
                expression = expression + "1";
                mathExpression.setText(expression);
                lastChar.add('1');
            }
        });
        buttonTwo.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                if(expression == "ERRO!!"){
                    lastChar.clear();
                    expression = "";
                }
                expression = expression + "2";
                mathExpression.setText(expression);
                lastChar.add('2');
            }
        });
        buttonThree.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                if(expression == "ERRO!!"){
                    lastChar.clear();
                    expression = "";
                }
                expression = expression + "3";
                mathExpression.setText(expression);
                lastChar.add('3');
            }
        });
        buttonFour.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                if(expression == "ERRO!!"){
                    lastChar.clear();
                    expression = "";
                }
                expression = expression + "4";
                mathExpression.setText(expression);
                lastChar.add('4');
            }
        });
        buttonFive.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                if(expression == "ERRO!!"){
                    lastChar.clear();
                    expression = "";
                }
                expression = expression + "5";
                mathExpression.setText(expression);
                lastChar.add('5');
            }
        });
        buttonSix.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                if(expression == "ERRO!!"){
                    lastChar.clear();
                    expression = "";
                }
                expression = expression + "6";
                mathExpression.setText(expression);
                lastChar.add('6');
            }
        });
        buttonSeven.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                if(expression == "ERRO!!"){
                    lastChar.clear();
                    expression = "";
                }
                expression = expression + "7";
                mathExpression.setText(expression);
//                last = '7';
                lastChar.add('7');
            }
        });
        buttonEight.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                if(expression == "ERRO!!"){
                    lastChar.clear();
                    expression = "";
                }
                expression = expression + "8";
                mathExpression.setText(expression);
                lastChar.add('8');
            }
        });
        buttonNine.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                if(expression == "ERRO!!"){
                    lastChar.clear();
                    expression = "";
                }
                expression = expression + "9";
                mathExpression.setText(expression);
                lastChar.add('9');
            }
        });
        buttonZero.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                if(expression == "ERRO!!"){
                    lastChar.clear();
                    expression = "";
                }
                expression = expression + "0";
                mathExpression.setText(expression);
                lastChar.add('0');
            }
        });
        buttonPlus.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                if(expression == "ERRO!!"){
                    lastChar.clear();
                    expression = "";
                    mathExpression.setText(expression);
                    return;
                }
                if(!lastChar.isEmpty()) {
                    if (!restriction.contains(lastChar.get(lastChar.size() - 1)) && expression != "") {
                        expression = expression + "+";
                        mathExpression.setText(expression);
                        lastChar.add('+');
                    }
                }
            }
        });
        buttonLess.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                if(expression == "ERRO!!"){
                    lastChar.clear();
                    expression = "";
                }
                if(lastChar.isEmpty()){
                    expression = expression + "-";
                    mathExpression.setText(expression);
                    lastChar.add('-');
                }
//                else if(lastChar.get(lastChar.size()-1) != '-' && lastChar.get(lastChar.size()-1) != '+' && lastChar.get(lastChar.size()-1) != '.'){
//                    expression = expression + "-";
//                    mathExpression.setText(expression);
//                    lastChar.add('-');
//                }
                else if(lastChar.get(lastChar.size()-1) == '-' || lastChar.get(lastChar.size()-1) == '+'){
                    if(lastChar.size()>=2){
                        if(!restriction.contains(lastChar.get(lastChar.size()-2))){
                            expression = expression + "-";
                            mathExpression.setText(expression);
                            lastChar.add('-');
                        }
                    }
                }
                else if(lastChar.get(lastChar.size()-1) != '-' && lastChar.get(lastChar.size()-1) != '+' && lastChar.get(lastChar.size()-1) != '.'){
                    expression = expression + "-";
                    mathExpression.setText(expression);
                    lastChar.add('-');
                }
            }
        });
        buttonTimes.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                if(expression == "ERRO!!"){
                    lastChar.clear();
                    expression = "";
                    mathExpression.setText(expression);
                    return;
                }
                if(!lastChar.isEmpty()) {
                    if (!restriction.contains(lastChar.get(lastChar.size() - 1)) && expression != "") {
                        expression = expression + "x";
                        mathExpression.setText(expression);
                        lastChar.add('x');
                    }
                }
            }
        });
        buttonDivided.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                if(expression == "ERRO!!"){
                    lastChar.clear();
                    expression = "";
                    mathExpression.setText(expression);
                    return;
                }
                if(!lastChar.isEmpty()) {
                    if (!restriction.contains(lastChar.get(lastChar.size() - 1)) && expression != "") {
                        expression = expression + "/";
                        mathExpression.setText(expression);
                        lastChar.add('/');
                    }
                }
            }
        });
        buttonC.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                expression = "";
                mathExpression.setText(expression);
                lastChar.clear();
            }
        });
        buttonPoint.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                if(expression == "ERRO!!"){
                    lastChar.clear();
                    expression = "";
                    mathExpression.setText(expression);
                    return;
                }
                if(!lastChar.isEmpty()) {
                    if (!restriction.contains(lastChar.get(lastChar.size() - 1))) {
                        usePoint = true;
                        for(int i = lastChar.size()-1; i >= 0; i--){
                            if(operations.contains(lastChar.get(i))){
                                break;
                            }
                            else if(lastChar.get(i) == '.'){
                                usePoint = false;
                                break;
                            }
                        }
                        if(usePoint){
                            expression = expression + ".";
                            mathExpression.setText(expression);
                            lastChar.add('.');
                        }
                    }
                }
            }
        });
        buttonBackSpace.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                if(expression == "ERRO!!"){
                    lastChar.clear();
                    expression = "";
                    mathExpression.setText(expression);
                    return;
                }
                if(expression != null && expression.length() > 0){
                    expression = expression.substring(0, expression.length()-1);
                    lastChar.remove(lastChar.size()-1);
                    mathExpression.setText(expression);
                }
            }
        });
        buttonEqual.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                isMainOperation = false;
                if(lastChar.isEmpty()) return;
                if(expression == "ERRO!!"){
                    lastChar.clear();
                    expression = "";
                    mathExpression.setText(expression);
                    return;
                }
                else if(!restriction.contains(lastChar.get(lastChar.size()-1))){
                    for(int i = lastChar.size()-1; i >= 0; i--){
                        if(mainOperations.contains(lastChar.get(i))) {
                            operationFromExpression = lastChar.get(i);
                            isMainOperation = true;
                            break;
                        }
                    }
                    if(!isMainOperation) {
                        for (int i = lastChar.size() - 1; i >= 0; i--) {
                            if (secondOperations.contains(lastChar.get(i))) {
                                if (i > 0) {
                                    if (secondOperations.contains(lastChar.get(i - 1))) {
                                        operationFromExpression = lastChar.get(i - 1);
                                        if (operationFromExpression == '-') {
                                            lastChar.set(i - 1, 'L');
                                            operationFromExpression = 'L';
                                        } else if (operationFromExpression == '+') {
                                            lastChar.set(i - 1, 'P');
                                            operationFromExpression = 'P';
                                        }
                                        break;
                                    } else {
                                        operationFromExpression = lastChar.get(i);
                                        if (operationFromExpression == '-'){
                                            lastChar.set(i, 'L');
                                            operationFromExpression = 'L';
                                        }
                                        else if (operationFromExpression == '+'){
                                            lastChar.set(i, 'P');
                                            operationFromExpression = 'P';
                                        }
                                        break;
                                    }
                                }
                            }
                        }
                        expression = "";
                        for(int k = 0; k < lastChar.size(); k++){
                            expression = expression + String.valueOf(lastChar.get(k));
                        }
                    }
                    if(operationFromExpression == 'P'){
                        String[] separated = expression.split(String.valueOf(operationFromExpression));
                        Double firstValue = Double.parseDouble(separated[0]);
                        Double secondValue = Double.parseDouble(separated[1]);
                        BigDecimal big1 = new BigDecimal(String.valueOf(firstValue));
                        BigDecimal big2 = new BigDecimal(String.valueOf(secondValue));
                        BigDecimal bigResult = big1.add(big2);
                        expression = String.valueOf(bigResult);
                        lastChar.clear();
                        operationFromExpression = '\0';
                        for(int i = 0; i < expression.length(); i++){
                            lastChar.add(expression.charAt(i));
                        }
                    }
                    else if(operationFromExpression == 'x'){
                        String[] separated = expression.split(String.valueOf(operationFromExpression));
                        Double firstValue = Double.parseDouble(separated[0]);
                        Double secondValue = Double.parseDouble(separated[1]);
                        BigDecimal big1 = new BigDecimal(String.valueOf(firstValue));
                        BigDecimal big2 = new BigDecimal(String.valueOf(secondValue));
                        BigDecimal bigResult = big1.multiply(big2);
                        expression = String.valueOf(bigResult);
                        lastChar.clear();
                        operationFromExpression = '\0';
                        for(int i = 0; i < expression.length(); i++){
                            lastChar.add(expression.charAt(i));
                        }
                    }
                    else if(operationFromExpression == '/'){
                        String[] separated = expression.split(String.valueOf(operationFromExpression));
                        Double firstValue = Double.parseDouble(separated[0]);
                        Double secondValue = Double.parseDouble(separated[1]);
                        Double result;
                        if(secondValue != 0){
                            BigDecimal big1 = new BigDecimal(String.valueOf(firstValue));
                            BigDecimal big2 = new BigDecimal(String.valueOf(secondValue));
                            BigDecimal bigResult = big1.divide(big2);
                            expression = String.valueOf(bigResult);
                        }
                        else if(secondValue == 0){
//                            result = firstValue / secondValue;
                            expression = "ERRO!!";
                        }
                        lastChar.clear();
                        operationFromExpression = '\0';
                        for(int i = 0; i < expression.length(); i++){
                            lastChar.add(expression.charAt(i));
                        }
                    }
                    else if(operationFromExpression == 'L'){
                        String[] separated = expression.split(String.valueOf(operationFromExpression));
                        Double firstValue = Double.parseDouble(separated[0]);
                        Double secondValue = Double.parseDouble(separated[1]);
                        BigDecimal big1 = new BigDecimal(String.valueOf(firstValue));
                        BigDecimal big2 = new BigDecimal(String.valueOf(secondValue));
                        BigDecimal bigResult = big1.subtract(big2);
                        expression = String.valueOf(bigResult);
                        lastChar.clear();
                        operationFromExpression = '\0';
                        for(int i = 0; i < expression.length(); i++){
                            lastChar.add(expression.charAt(i));
                        }
                    }
                    mathExpression.setText(expression);
                }
            }
        });
    }
}