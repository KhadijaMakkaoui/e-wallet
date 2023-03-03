// To parse this JSON data, do
//
//     final transaction = transactionFromJson(jsonString);

import 'dart:convert';

Transaction transactionFromJson(String str) => Transaction.fromJson(json.decode(str));

String transactionToJson(Transaction data) => json.encode(data.toJson());

class Transaction {
  Transaction({
    required this.id,
    required this.amount,
    required this.createdAt,
    required this.transactionType,
    required this.walletId,
  });

  int id;
  double amount;
  DateTime createdAt;
  String transactionType;
  String walletId;

  factory Transaction.fromJson(Map<String, dynamic> json) => Transaction(
    id: json["id"],
    amount: json["amount"]?.toDouble(),
    createdAt: DateTime.parse(json["createdAt"]),
    transactionType: json["transactionType"],
    walletId: json["walletId"],
  );

  Map<String, dynamic> toJson() => {
    "id": id,
    "amount": amount,
    "createdAt": createdAt.toIso8601String(),
    "transactionType": transactionType,
    "walletId": walletId,
  };
}
