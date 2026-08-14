#include <QtTest>
#include <QCoreApplication>

using String = std::string;
class Padding_Tester : public QObject
{ Q_OBJECT
public:
	Padding_Tester();
	~Padding_Tester();
private slots:
	void initTestCase();
	void cleanupTestCase();
	void testCase1_getPKCS7PaddedLength_data();
	void testCase1_getPKCS7PaddedLength();
	void testCase2_doPKCS7Padding_data();
	void testCase2_doPKCS7Padding();
	void testCase3_doPKCS7UnPadding_data();
	void testCase3_doPKCS7UnPadding();
private:
};
Q_DECLARE_METATYPE(String);
//-------- impl ---------
Padding_Tester::Padding_Tester()
{
}
Padding_Tester::~Padding_Tester()
{
}
void Padding_Tester::initTestCase()
{
}
void Padding_Tester::cleanupTestCase()
{
}
void Padding_Tester::testCase1_getPKCS7PaddedLength_data()
{
}
void Padding_Tester::testCase1_getPKCS7PaddedLength()
{
}
void Padding_Tester::testCase2_doPKCS7Padding_data()
{
}
void Padding_Tester::testCase2_doPKCS7Padding()
{
}
void Padding_Tester::testCase3_doPKCS7UnPadding_data()
{
}
void Padding_Tester::testCase3_doPKCS7UnPadding()
{
}
QTEST_MAIN(Padding_Tester)
#include "Padding_Tester.moc"
