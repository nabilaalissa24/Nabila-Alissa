package id.sch.smktelkom_mlg.xirpl6022.daftarlombaosu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etUser;
    Button bOk;
    TextView tvHasil, JHasil, MHasil, AHasil;
    RadioButton rbL, rbP;
    CheckBox cbS, cbC, cbM, cbT;
    Spinner spAsal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUser = (EditText) findViewById(R.id.editTextUser);
        bOk = (Button) findViewById(R.id.buttonOK);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        JHasil = (TextView) findViewById(R.id.textViewHasilJ);
        MHasil = (TextView) findViewById(R.id.textViewHasilM);
        AHasil = (TextView) findViewById(R.id.textViewHasilA);

        rbL = (RadioButton) findViewById(R.id.radioButtonL);
        rbP = (RadioButton) findViewById(R.id.radioButtonP);

        cbS = (CheckBox) findViewById(R.id.checkBoxS);
        cbC = (CheckBox) findViewById(R.id.checkBoxC);
        cbM = (CheckBox) findViewById(R.id.checkBoxM);
        cbT = (CheckBox) findViewById(R.id.checkBoxT);

        spAsal = (Spinner) findViewById(R.id.spinnerAsal);


        bOk.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                doProcess();
                doClick();

            }
        });
    }


    private void doProcess() {
        if (isValid()) {
            String user = etUser.getText().toString();
            tvHasil.setText("Username " + user);
        }
    }


    private boolean isValid() {
        boolean valid = true;

        /*Username*/
        String user = etUser.getText().toString();

        if (user.isEmpty()) {
            etUser.setError("Username belum diisi");
            valid = false;
        } else {
            etUser.setError(null);
        }


        return valid;
    }


    private void doClick() {
        String Jumhasil = null;


        if (rbL.isChecked()) {
            Jumhasil = rbL.getText().toString();
        } else if (rbP.isChecked()) {
            Jumhasil = rbP.getText().toString();
        }

        if (Jumhasil == null) {
            JHasil.setText("Belum memilih Jenis Kelamin");
        } else {
            JHasil.setText("Jenis Kelamin : " + Jumhasil);
        }


        String hasilMod = "Mode Anda:\n";
        int startlen = hasilMod.length();
        if (cbS.isChecked()) hasilMod += cbS.getText() + "\n";
        if (cbC.isChecked()) hasilMod += cbC.getText() + "\n";
        if (cbM.isChecked()) hasilMod += cbM.getText() + "\n";
        if (cbT.isChecked()) hasilMod += cbT.getText() + "\n";

        if (hasilMod.length() == startlen) hasilMod += "Tidak ada pada Pilihan";
        MHasil.setText(hasilMod);

        AHasil.setText("Asal Kota: " + spAsal.getSelectedItem());
    }

}
