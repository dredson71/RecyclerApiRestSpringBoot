package com.recycler.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recycler.main.entities.QrCode;

public interface QRCodeDAO extends JpaRepository<QrCode,Integer> {

}
