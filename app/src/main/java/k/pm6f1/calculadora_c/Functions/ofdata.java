package k.pm6f1.calculadora_c.Functions;

import android.widget.EditText;
import android.widget.Toast;

import k.pm6f1.calculadora_c.Models.data;

public class ofdata {
    public data object = new data();
    EditText et_small, et_big;

    public void save_value(int val_number) {
        try {
            double actual_val = Double.valueOf(et_big.getText().toString());

            switch (val_number) {

                case 1:

                    object.setValue_1(actual_val);
                    et_small.setText(String.valueOf(object.getValue_1()));
                    et_big.setText("");

                    break;
                case 2:
                    object.setValue_2(actual_val);
                    et_small.setText(String.valueOf(object.getValue_1()));
                    et_big.setText("");
                    break;
                default:
                    //ins
                    break;
            }
        }
        catch(Exception e){

        }

    }
    public String add_numbers(char option_selected, String EditText_value){
        switch (option_selected){
            case '0':
                EditText_value+="0";
                break;
            case '1':
                EditText_value+="1";
                break;
            case '2':
                EditText_value+="2";
                break;
            case '3':
                EditText_value+="3";
                break;
            case '4':
                EditText_value+="4";
                break;
            case '5':
                EditText_value+="5";
                break;
            case '6':
                EditText_value+="6";
                break;
            case '7':
                EditText_value+="7";
                break;
            case '8':
                EditText_value+="8";
                break;
            case '9':
                EditText_value+="9";
                break;
            case '.':
                EditText_value+=".";
        }

        return EditText_value;
    }

}
