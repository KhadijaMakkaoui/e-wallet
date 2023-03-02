class Transaction{
  final String title;
  final String date;
 /* final String amount;*/
  final String type;


  Transaction({
    required this.title,
    required this.date,
    /*required this.amount,*/
    required this.type,
  });
  static  List<Transaction> ListTransaction(){
  return [
    Transaction(
      title: 'Item 1',
      date: 'This is the first item',
      type: 'debit',
    ),
    Transaction(
      title: 'Item 2',
      date: 'This is the second item',
      type: 'credit',
    ),
    Transaction(
      title: 'Item 3',
      date: 'This is the third item',
      type: 'debit',
    ),
    Transaction(
      title: 'Item 4',
      date: 'This is the fourth item',
      type: 'credit',
    ),
    Transaction(
      title: 'Item 4',
      date: 'This is the fourth item',
      type: 'credit',
    ),
    Transaction(
      title: 'Item 4',
      date: 'This is the fourth item',
      type: 'debit',
    ),
    Transaction(
      title: 'Item 4',
      date: 'This is the fourth item',
      type: 'credit',
    ),
  ];}
}