import 'package:flutter/material.dart';

import '../models/Transaction.dart';

class TransactionListItem extends StatelessWidget {
  final Transaction transaction;


  TransactionListItem({required this.transaction});

  @override
  Widget build(BuildContext context) {
    return ListTile(
      leading: CircleAvatar(
        backgroundColor: transaction.type == 'credit' ? Colors.red[100] : Colors.green[100],
        child: Icon(Icons.attach_money_sharp,
          color: transaction.type == 'credit' ? Colors.red : Colors.green,),
      ),
      title: Text(
        transaction.title,
        style: const TextStyle(
          fontWeight: FontWeight.bold,
          fontSize: 16.0,
        ),
      ),
      subtitle: Text(
        transaction.date.toString(),
        style: TextStyle(
          color: Colors.grey[600],
        ),
      ),
      /*trailing: Text(
        '\$${transaction.amount}',
        style: TextStyle(
          fontWeight: FontWeight.bold,
          fontSize: 16.0,
        ),
      ),*/
    );
  }
}