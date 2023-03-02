import 'package:flutter/material.dart';
import 'package:front_end/widgets/transaction_list_item.dart';

import '../models/Transaction.dart';
class TransactionListView extends StatelessWidget {
final List<Transaction> transactions;

TransactionListView({ required this.transactions});

  @override
  Widget build(BuildContext context) {
    return  ListView.separated(
        itemCount: transactions.length,
        separatorBuilder: (BuildContext context, int index) {
          return const Divider();
        },
        itemBuilder: (BuildContext context, int index) {
          return TransactionListItem(transaction:transactions[index]);
        },

    );
  }
}
