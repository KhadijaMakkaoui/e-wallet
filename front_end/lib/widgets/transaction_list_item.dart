import 'package:flutter/material.dart';

import '../models/Transaction.dart';

class TransactionListItem extends StatelessWidget {
  final Transaction transaction;


  TransactionListItem({required this.transaction});

  @override
  Widget build(BuildContext context) {
    return ListTile(
      leading: CircleAvatar(
        backgroundColor: transaction.transactionType == 'WITHDRAW' ? Colors.red[100] : Colors.green[100],
        child: Icon(Icons.attach_money_sharp,
          color: transaction.transactionType == 'WITHDRAW' ? Colors.red : Colors.green,),
      ),
      title: Text(
        transaction.transactionType.toString(),
        style: const TextStyle(
          fontWeight: FontWeight.bold,
          fontSize: 16.0,
        ),
      ),
      subtitle: Text(
        transaction.createdAt.toString(),
        style: TextStyle(
          color: Colors.grey[600],
        ),
      ),
      trailing: Text(
        /*'\$${transaction.amount}'*/
       transaction.transactionType == 'WITHDRAW' ? '-'+transaction.amount.toString()+'MAD':'+'+transaction.amount.toString()+'MAD'        /*transaction.amount.toString()*/ ,

        style: TextStyle(
          fontWeight: FontWeight.bold,
          fontSize: 16.0,
          color: transaction.transactionType == 'WITHDRAW' ? Colors.red : Colors.green,
      ),
      ),
    );
  }
}