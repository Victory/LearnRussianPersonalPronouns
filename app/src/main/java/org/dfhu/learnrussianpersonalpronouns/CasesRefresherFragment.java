package org.dfhu.learnrussianpersonalpronouns;


import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class CasesRefresherFragment extends Fragment implements View.OnClickListener {
    private View theView;

    private int[] buttonIds = new int[] {
            R.id.buttonNominativeInfo,
            R.id.buttonAccusativeInfo,
            R.id.buttonGenitiveInfo,
            R.id.buttonDativeInfo,
            R.id.buttonInstrumentalInfo,
            R.id.buttonPrepositionalInfo
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        theView = inflater.inflate(R.layout.cases_referesher_fragment, container, false);

        for (int buttonId: buttonIds) {
            theView.findViewById(buttonId).setOnClickListener(this);
        }
        return theView;
    }

    public static CasesRefresherFragment newInstance ()
    {
        return new CasesRefresherFragment();
    }

    @Override
    public void onClick(View view) {

        switch(view.getId()) {
            case R.id.buttonNominativeInfo:
                showCaseInfo(R.string.nominativeCaseTitle, R.layout.case_info_nom);
                break;
            case R.id.buttonAccusativeInfo:
                showCaseInfo(R.string.accusativeCaseTitle, R.layout.case_info_accu);
                break;
            default:
                Toast.makeText(getActivity(), "Not implemented", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void showCaseInfo(int caseTitleId, int caseLayoutId) {

        LayoutInflater inflater = getActivity().getLayoutInflater();

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(caseTitleId);
        builder.setView(inflater.inflate(caseLayoutId, null));
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
