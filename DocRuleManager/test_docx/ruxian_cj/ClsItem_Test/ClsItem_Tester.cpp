#include <QtTest>
#include <QCoreApplication>

using String = std::string;
class ClsItem_Tester : public QObject
{ Q_OBJECT
public:
	ClsItem_Tester();
	~ClsItem_Tester();
private slots:
	void initTestCase();
	void cleanupTestCase();
	void testCase1_sum_data();
	void testCase1_sum();
	void testCase2_avg_data();
	void testCase2_avg();
private:
};
Q_DECLARE_METATYPE(String);
//-------- impl ---------
ClsItem_Tester::ClsItem_Tester()
{
}
ClsItem_Tester::~ClsItem_Tester()
{
}
void ClsItem_Tester::initTestCase()
{
}
void ClsItem_Tester::cleanupTestCase()
{
}
void ClsItem_Tester::testCase1_sum_data()
{
}
void ClsItem_Tester::testCase1_sum()
{
}
void ClsItem_Tester::testCase2_avg_data()
{
}
void ClsItem_Tester::testCase2_avg()
{
}
QTEST_MAIN(ClsItem_Tester)
#include "ClsItem_Tester.moc"
