
package com.ashishkumar.dscsolutionbefit.WalkandStep;

import android.content.pm.PackageManager;

import com.ashishkumar.dscsolutionbefit.WalkandStep.services.AbstractStepDetectorService;
import com.ashishkumar.dscsolutionbefit.WalkandStep.services.AccelerometerStepDetectorService;
import com.ashishkumar.dscsolutionbefit.WalkandStep.services.HardwareStepDetectorService;
import com.ashishkumar.dscsolutionbefit.WalkandStep.utils.AndroidVersionHelper;




public class Factory {



    public static Class<? extends AbstractStepDetectorService> getStepDetectorServiceClass(PackageManager pm){
        if(pm != null && AndroidVersionHelper.supportsStepDetector(pm)) {
            return HardwareStepDetectorService.class;
        }else{
            return AccelerometerStepDetectorService.class;
        }
    }
}
