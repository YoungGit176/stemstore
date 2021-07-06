package com.example.stemstore.service;

import com.example.stemstore.bean.Collect;
import com.example.stemstore.vo.CollectionVO;

import java.util.List;

public interface CollectService {
    List<CollectionVO> queryCollect(Long userId);

    int addCollect(Collect  collect);

    int queryCollectByUserIdAndGameId(Collect collect);

    int removeCollect(Collect collect);

}
