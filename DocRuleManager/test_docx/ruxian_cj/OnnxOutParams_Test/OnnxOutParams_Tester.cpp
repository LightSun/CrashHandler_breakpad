#include <QtTest>
#include <QCoreApplication>

using String = std::string;
class OnnxOutParams_Tester : public QObject
{ Q_OBJECT
public:
	OnnxOutParams_Tester();
	~OnnxOutParams_Tester();
private slots:
	void initTestCase();
	void cleanupTestCase();
	void testCase1_resetAll_data();
	void testCase1_resetAll();
	void testCase2_getOutImages_data();
	void testCase2_getOutImages();
	void testCase3_getRects_data();
	void testCase3_getRects();
	void testCase4_getContours_data();
	void testCase4_getContours();
	void testCase5_getProbs_data();
	void testCase5_getProbs();
	void testCase6_getLabels_data();
	void testCase6_getLabels();
	void testCase7_getClsRoi_data();
	void testCase7_getClsRoi();
	void testCase8_getBoxConfidences_data();
	void testCase8_getBoxConfidences();
private:
};
Q_DECLARE_METATYPE(String);
//-------- impl ---------
OnnxOutParams_Tester::OnnxOutParams_Tester()
{
}
OnnxOutParams_Tester::~OnnxOutParams_Tester()
{
}
void OnnxOutParams_Tester::initTestCase()
{
}
void OnnxOutParams_Tester::cleanupTestCase()
{
}
void OnnxOutParams_Tester::testCase1_resetAll_data()
{
}
void OnnxOutParams_Tester::testCase1_resetAll()
{
}
void OnnxOutParams_Tester::testCase2_getOutImages_data()
{
}
void OnnxOutParams_Tester::testCase2_getOutImages()
{
}
void OnnxOutParams_Tester::testCase3_getRects_data()
{
}
void OnnxOutParams_Tester::testCase3_getRects()
{
}
void OnnxOutParams_Tester::testCase4_getContours_data()
{
}
void OnnxOutParams_Tester::testCase4_getContours()
{
}
void OnnxOutParams_Tester::testCase5_getProbs_data()
{
}
void OnnxOutParams_Tester::testCase5_getProbs()
{
}
void OnnxOutParams_Tester::testCase6_getLabels_data()
{
}
void OnnxOutParams_Tester::testCase6_getLabels()
{
}
void OnnxOutParams_Tester::testCase7_getClsRoi_data()
{
}
void OnnxOutParams_Tester::testCase7_getClsRoi()
{
}
void OnnxOutParams_Tester::testCase8_getBoxConfidences_data()
{
}
void OnnxOutParams_Tester::testCase8_getBoxConfidences()
{
}
QTEST_MAIN(OnnxOutParams_Tester)
#include "OnnxOutParams_Tester.moc"
