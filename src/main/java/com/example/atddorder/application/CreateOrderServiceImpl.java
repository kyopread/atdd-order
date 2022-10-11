package com.example.atddorder.application;

import com.example.atddorder.domain.PendingOrder;
import com.example.atddorder.domain.PendingOrderRepository;
import org.springframework.stereotype.Service;

// static 이 아닌 inner class 는 gc 가 되지 않는 문제를 가지고 있다.
@Service
class CreateOrderServiceImpl implements CreateOrderService {
    private final PendingOrderRepository pendingOrderRepository;

    CreateOrderServiceImpl(PendingOrderRepository pendingOrderRepository) {
        this.pendingOrderRepository = pendingOrderRepository;
    }

    @Override
    public PendingOrder createPendingOrder(PendingOrderRequest request) {
        PendingOrder pendingOrder = new PendingOrder(request.getProductId(), request.getQuantity());
        return pendingOrderRepository.save(pendingOrder);
    }

}
