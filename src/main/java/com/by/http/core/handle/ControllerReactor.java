package com.by.http.core.handle;

import com.by.http.common.config.ITreeConfig;
import com.by.http.model.PageModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ControllerReactor {
    private final static Logger LOGGER = LoggerFactory.getLogger(ControllerReactor.class);
    private final static String[] uris = {"/", "/index"};

    public static Object getClazzFromList(String uri) {
        if (uri.equals(uris[0]) || uri.equals(uris[1])) {
            PageModel pageModel;
            if(ITreeConfig.INDEX_CHANGE){
                pageModel= new PageModel();
                pageModel.setPagePath(ITreeConfig.INDEX_PAGE);
            }
            return new PageModel();
        }
        return null;
    }
}
