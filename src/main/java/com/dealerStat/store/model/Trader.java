package com.dealerStat.store.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name = "userAccount")
@Table(name = "trader", schema = "public", catalog = "DealerStat")
public class Trader extends AbstractUser {

}
