package com.naild2d.android.service;

import com.naild2d.android.api.NoticeApi;
import com.naild2d.android.json.IndexJSONObject;
import com.naild2d.android.log.Logger;
import com.naild2d.android.model.Notice;

/**
 * Created by ebread on 2015/6/23.
 */
public class NoticeService {
    private NoticeApi noticeApi = null;

    public NoticeService() {
        noticeApi = new NoticeApi();
    }

    public Notice[] listReadNotices(String type, int page, int pageSize) {
        return listNotices(type, page, pageSize, true);
    }

    public Notice[] listUnreadNotices(String type, int page, int pageSize) {
        return listNotices(type, page, pageSize, false);
    }

    private Notice[] listNotices(String type, int page, int pageSize, boolean read) {
        String jString = noticeApi.list(read, type, pageSize, page);
        try {
            IndexJSONObject json = new IndexJSONObject(jString);
            return json.getObjectArray(Notice.class);
        } catch (Exception e) {
            Logger.e(e);
        }
        return null;
    }

    public Notice getNotice(int noticeId) {
        String jString = noticeApi.details(String.valueOf(noticeId));
        try {
            IndexJSONObject json = new IndexJSONObject(jString);
            return json.getObject(Notice.class);
        } catch (Exception e) {
            Logger.e(e);
        }
        return null;
    }

    public boolean readNotice(int noticeId) {
        return noticeApi.markRead(String.valueOf(noticeId));
    }


}
