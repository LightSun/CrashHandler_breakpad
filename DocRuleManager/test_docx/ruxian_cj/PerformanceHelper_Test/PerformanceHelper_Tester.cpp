#include <QtTest>
#include <QCoreApplication>

using String = std::string;
class PerformanceHelper_Tester : public QObject
{ Q_OBJECT
public:
	PerformanceHelper_Tester();
	~PerformanceHelper_Tester();
private slots:
	void initTestCase();
	void cleanupTestCase();
	void testCase1_formatTime_data();
	void testCase1_formatTime();
	void testCase2_begin_data();
	void testCase2_begin();
	void testCase3_end_data();
	void testCase3_end();
	void testCase4_print_data();
	void testCase4_print();
	void testCase5_printTo_data();
	void testCase5_printTo();
	void testCase6_printTo_data();
	void testCase6_printTo();
private:
};
Q_DECLARE_METATYPE(String);
//-------- impl ---------
PerformanceHelper_Tester::PerformanceHelper_Tester()
{
}
PerformanceHelper_Tester::~PerformanceHelper_Tester()
{
}
void PerformanceHelper_Tester::initTestCase()
{
}
void PerformanceHelper_Tester::cleanupTestCase()
{
}
void PerformanceHelper_Tester::testCase1_formatTime_data()
{
}
void PerformanceHelper_Tester::testCase1_formatTime()
{
}
void PerformanceHelper_Tester::testCase2_begin_data()
{
}
void PerformanceHelper_Tester::testCase2_begin()
{
}
void PerformanceHelper_Tester::testCase3_end_data()
{
}
void PerformanceHelper_Tester::testCase3_end()
{
}
void PerformanceHelper_Tester::testCase4_print_data()
{
}
void PerformanceHelper_Tester::testCase4_print()
{
}
void PerformanceHelper_Tester::testCase5_printTo_data()
{
}
void PerformanceHelper_Tester::testCase5_printTo()
{
}
void PerformanceHelper_Tester::testCase6_printTo_data()
{
}
void PerformanceHelper_Tester::testCase6_printTo()
{
}
QTEST_MAIN(PerformanceHelper_Tester)
#include "PerformanceHelper_Tester.moc"
