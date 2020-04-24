/**
 * OpenAPI Petstore
 * This is a sample server Petstore server. For this sample, you can use the api key `special-key` to test the authorization filters.
 *
 * The version of the OpenAPI document: 1.0.0
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

/*
 * PFXUser.h
 *
 * A User who is purchasing from the pet store
 */

#ifndef PFXUser_H
#define PFXUser_H

#include <QJsonObject>

#include <QString>

#include "PFXEnum.h"
#include "PFXObject.h"

namespace test_namespace {

class PFXUser : public PFXObject {
public:
    PFXUser();
    PFXUser(QString json);
    ~PFXUser() override;

    QString asJson() const override;
    QJsonObject asJsonObject() const override;
    void fromJsonObject(QJsonObject json) override;
    void fromJson(QString jsonString) override;

    qint64 getId() const;
    void setId(const qint64 &id);
    bool is_id_Set() const;
    bool is_id_Valid() const;

    QString getUsername() const;
    void setUsername(const QString &username);
    bool is_username_Set() const;
    bool is_username_Valid() const;

    QString getFirstName() const;
    void setFirstName(const QString &first_name);
    bool is_first_name_Set() const;
    bool is_first_name_Valid() const;

    QString getLastName() const;
    void setLastName(const QString &last_name);
    bool is_last_name_Set() const;
    bool is_last_name_Valid() const;

    QString getEmail() const;
    void setEmail(const QString &email);
    bool is_email_Set() const;
    bool is_email_Valid() const;

    QString getPassword() const;
    void setPassword(const QString &password);
    bool is_password_Set() const;
    bool is_password_Valid() const;

    QString getPhone() const;
    void setPhone(const QString &phone);
    bool is_phone_Set() const;
    bool is_phone_Valid() const;

    qint32 getUserStatus() const;
    void setUserStatus(const qint32 &user_status);
    bool is_user_status_Set() const;
    bool is_user_status_Valid() const;

    virtual bool isSet() const override;
    virtual bool isValid() const override;

private:
    void initializeModel();

    qint64 id;
    bool m_id_isSet;
    bool m_id_isValid;

    QString username;
    bool m_username_isSet;
    bool m_username_isValid;

    QString first_name;
    bool m_first_name_isSet;
    bool m_first_name_isValid;

    QString last_name;
    bool m_last_name_isSet;
    bool m_last_name_isValid;

    QString email;
    bool m_email_isSet;
    bool m_email_isValid;

    QString password;
    bool m_password_isSet;
    bool m_password_isValid;

    QString phone;
    bool m_phone_isSet;
    bool m_phone_isValid;

    qint32 user_status;
    bool m_user_status_isSet;
    bool m_user_status_isValid;
};

} // namespace test_namespace

Q_DECLARE_METATYPE(test_namespace::PFXUser)

#endif // PFXUser_H
