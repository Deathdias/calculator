package com.example.d1;

public class CalculatorModel {
    private int firstArg;
    private int secondArg;

    private StringBuilder inputStr = new StringBuilder();

    private int actionSelected;
    private State state;

    private enum State{
        firstArginput,
        secondArginput,
        resultShow
    }

    public CalculatorModel(){
        state= State.firstArginput;
    }
    public void onNumPressed(int buttonId){

        if (state == State.resultShow){
            state = State.firstArginput;
            inputStr.setLength(0);
        }

        if(inputStr.length()<=9){
            switch (buttonId){
                case R.id.zero:
                    if (inputStr.length()!=0){
                        inputStr.append("0");
                    }
                    break;
                case R.id.one:
                    inputStr.append("1");
                    break;
                case R.id.two:
                    inputStr.append("2");
                    break;
                case R.id.three:
                    inputStr.append("3");
                    break;
                case R.id.four:
                    inputStr.append("4");
                    break;
                case R.id.five:
                    inputStr.append("5");
                    break;
                case R.id.six:
                    inputStr.append("6");
                    break;
                case R.id.seven:
                    inputStr.append("7");
                    break;
                case R.id.eight:
                    inputStr.append("8");
                    break;
                case R.id.nine:
                    inputStr.append("9");
                    break;
                case R.id.dot:
                    inputStr.append(".");
                    break;
                case R.id.erase:
                    inputStr.delete(0,inputStr.length());
                    break;
//                case R.id.br_l:
//                    inputStr.delete(0,inputStr.length());
//                    inputStr.append("Not work yet!");
//                    inputStr.append("(");
//                    break;
//                case R.id.br_r:
//                    inputStr.delete(0,inputStr.length());
//                    inputStr.append("Not work yet!");
//                    inputStr.append(")");
//                    break;
//                case R.id.plus_or_minus:
//                    inputStr.delete(0,inputStr.length());
//                    inputStr.append("Not work yet!");
//                    break;
            }
        }
    }
    public void onActionPressed(int actionId){
        if (actionId == R.id.equal){
            secondArg = Integer.parseInt(inputStr.toString());
            state = State.resultShow;
            inputStr.setLength(0);
            switch (actionSelected){
                case R.id.plus:
                    inputStr.append(firstArg + secondArg);
                    break;
                case R.id.minus:
                    inputStr.append(firstArg - secondArg);
                    break;
                case R.id.multiply:
                    inputStr.append(firstArg * secondArg);
                    break;
                case R.id.division:
                    inputStr.append(firstArg / secondArg);
                    break;
                case R.id.erase:
                    inputStr.delete(0,inputStr.length());
                    state = State.firstArginput;
                    break;
            }
        }
        else if(inputStr.length()>0 && state == State.firstArginput){
            firstArg = Integer.parseInt(inputStr.toString());
            state = State.firstArginput;
            inputStr.setLength(0);
            switch (actionId) {
                case R.id.plus:
                    actionSelected = R.id.plus;
                    break;
                case R.id.minus:
                    actionSelected = R.id.minus;
                    break;
                case R.id.multiply:
                    actionSelected = R.id.multiply;
                    break;
                case R.id.division:
                    actionSelected = R.id.division;
                    break;
                case R.id.erase:
                    inputStr.delete(0,inputStr.length());
                    state = State.firstArginput;
                    break;
                case R.id.br_l:
                    inputStr.delete(0,inputStr.length());
                    inputStr.append("Not work yet!");
                    state = State.firstArginput;
                    break;
                case R.id.br_r:
                    inputStr.delete(0,inputStr.length());
                    inputStr.append("Not work yet!");
                    state = State.firstArginput;
                    break;
                case R.id.plus_or_minus:
                    inputStr.delete(0,inputStr.length());
                    inputStr.append("Not work yet!");
                    state = State.firstArginput;
                    break;
            }
        }
        else if(inputStr.length()>0 && state == State.secondArginput) {
            secondArg = Integer.parseInt(inputStr.toString());
            state = State.secondArginput;
            inputStr.setLength(0);
            switch (actionId) {
                case R.id.erase:
                    inputStr.delete(0,inputStr.length());
                    state = State.firstArginput;
                    break;
                case R.id.br_l:
                    state = State.firstArginput;
                    break;
//                case R.id.br_r:
//                    state = State.firstArginput;
//                    break;
//                case R.id.plus_or_minus:
//                    state = State.firstArginput;
//                    break;
            }
        }
    }

    public String getText(){
        return inputStr.toString();
    }
}
