��ܣ�  io        ���߳�   ������
       ���ݿ�     jdbc     servlet
�־û�������   io   ���л�     ���ݿ�

MyBatis����һ���־ò�Ŀ�ܣ� ���ڲ���װ��jdbc������
          ����ֻ��עsql������д��
          ����Ҫ�ٻ��Ѿ���ȥ��ע������������ȡ���ӵȲ�����������Ҫ������xml�ļ��У�


   ǰ��ibatis�� ����ʹ��mybatis��ʱ�򣬵ײ�İ� ����ibatis��
      2013��Դ���ϴ���github


Hibernate��һ���־ò�ȫ�Զ���ORM��ܣ�     ʵ�����ӳ��
���Բ�дsql��䣬���ǰ�����������˼����������ݿ��е����⣡


Mybatis:�־ò���Զ���ORM��ܣ�֧�ֶ��ƻ�sql��   sql����ӳ��
ibatis��ǰ��


������ַ��http://www.mybatis.org/mybatis-3/zh/index.html

githubԴ�룺https://github.com/mybatis/mybatis-3/tree/master/src/main/java/org/apache/ibatis

 ��Hibernateһ�� ���� �־ò�Ŀ�ܣ�

 Hibernate��һ��ORMӳ��ĳ־ò�Ŀ�ܣ�

 O�� object
 R�� relation
 M�� mapping


����

  01.Hibernate��һ��ȫ�Զ���ȫ�������ĳ־ò��ܣ��ײ���Ҫ�����ǶԶ���Ĳ���ת����sql���֮����ִ�У�
     MyBatis��һ�����Զ��ĳ־ò��ܣ���Ҫ���ǳ���Ա�ֶ���дsql��䣡
  02.Hiberntae���ܴ����ӵ�sql��䣡
     MyBatis���Բ������ӵ�sql!
  03.���ǿ��԰�sql���Ž�xml�ļ��У������ǵ�java��������룡�������Ǻ���ά����
  04.MyBatis����ѧ������ʹ�ã�




SqlSessionFactoryBuilder
01.���غ��������ļ���
02. ��������ڷ������ڣ�
03.һ��������SqlSessionFactory�����SqlSessionFactoryBuilder��û�ã�

�����������κ�ʱ��ʵ������ʹ�ú����١�һ�������� SqlSessionFactory �Ͳ���Ҫ
�ٱ������ˡ����� SqlSessionFactoryBuilder ʵ������õ��������Ƿ������ڣ���һ�����ط���
�������������� SqlSessionFactoryBuilder ������� SqlSessionFactory ʵ��������ò�Ҫ��
ʱ�䡢��Դ���ڽ��� XML �ļ��ϣ�����Ҫ���н�ų���������Ҫ���顣



SqlSessionFactory
01.SqlSession�ĻỰ����
02.������Ӧ�ó�����  ֻ����һ�����󼴿ɣ�  ������

һ��������SqlSessionFactory ���������Ӧ�ó��������������������С����ٻ����
û������ȥ�����������´����������ʵ���ǲ�Ҫ��һ��Ӧ���ж�δ��� SqlSessionFactory��
�������ᱻ��Ϊ��ûƷζ�������� SqlSessionFactory ��õ�������Χ��һ��Ӧ�õ���������
��Χ��������ɶ��ַ�ʽ��ʵ�֣���򵥵ķ�ʽ��ʹ�� Singleton ģʽ��̬ Singleton ģʽ��
��Щ�������������һ�������������ڹ��� SqlSessionFactory ���������ڡ�


SqlSession
01.��ɾ�Ĳ������ִ���ߣ�
02.���������߳��й���
03.ȷ���Ự�����󣬹رջỰ�� ��finally{}�йرգ�

ÿ���̶߳���һ�� SqlSession ʵ����SqlSession ʵ���ǲ�������ģ����Ҳ����̰߳�ȫ
�ġ������õ��������� request ���� method������Ҫ��һ����̬�ֶλ���һ�����ʵ���ֶ���
���� SqlSession ʵ�����á�Ҳ��Ҫ���κ�һ�������������� Servlet ����е� HttpSession��
������ SqlSession �����á������������һ�� WEB ��ܣ����԰� SqlSession ��������������
�� HTTP ������Χ��Ҳ����˵�����յ�һ�� HTTP ���������Դ�һ�� SqlSession��������
response ����ʱ���Ϳ��԰� SqlSession �رա��رջỰ�Ƿǳ���Ҫ�ģ���Ӧ��Ҫȷ���Ự��һ
�� finally ���б��رա�



ʹ��Idea ������һ��myBatis��Ŀ
01.����maven��Ŀ
02.���� pom�ļ�  ������Ҫ��jar
03.��srcĿ¼�µ�main�� ���� source�ļ�  �����ļ����ó� resouce�ļ�
04.���ĵ���copy ���������ļ� ������д
    001.jdbc.properties
    002.sql������ڵ�mapper.xml�ļ�
    003.mapper.xml�ļ��������resource�ļ�����
05.�������ǵĽӿ� ��д����
06.������Ҫ��ʵ���� �Լ�mapper.xml�ļ�
    ��Ҫע�����mapper.xml�ļ��ĸ��ڵ��� mapper ��Ҫһ�����Խ�namespace
07.��д������ ����








��Ҫ��sql�ű�


DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `age` int(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;




# �� $������

01.$ ����ȫ �ײ�ʵ����statement����

    select * from student  where id=${id}
    �������id�������11    ����֮��
    select * from student  where id=11


   # ��ȫ   �ײ�ʵ����PreparedStatement����
    select * from student  where id=#{id}
    �������id�������11    ����֮��
    select * from student  where id=?

02.��sql�����Ҫ�����ʱ��
     order  by  ${id}
     ֻ������Ҫ�����ʱ�� ʹ��$ .
     ����ʱ������#���Բ���$




