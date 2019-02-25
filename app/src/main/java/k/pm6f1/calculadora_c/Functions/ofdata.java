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
}
