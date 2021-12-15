package com.casestudy.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casestudy.library.bean.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {

}
